package com.avia.demo.repository;

import com.avia.demo.dto.CargoInfoDTO;
import com.avia.demo.dto.FlightInfoDTO;
import jakarta.persistence.*;

import java.util.Date;

/**
 * Main repository class with native sql-queries for aggregate information from DB
 */
public class CustomFlightRepositoryImpl implements CustomFlightRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CargoInfoDTO findAggregateCargoInfo(Date date, int flightNumber) {
        Query query = entityManager.createNativeQuery("""
                select
                	ROUND(coalesce(SUM(c.weight)FILTER(where c.weight_unit = 0 and c.cargo_type = 0) +
                	SUM(c.weight)FILTER(where c.weight_unit = 1 and c.cargo_type = 0)*0.4536, 0), 1) as sum_cargo_weight_kg,
                	ROUND(coalesce(SUM(c.weight)FILTER(where c.weight_unit = 0 and c.cargo_type = 1) +
                	SUM(c.weight)FILTER(where c.weight_unit = 1 and c.cargo_type = 1)*0.4536, 0), 1) as sum_baggage_weight_kg,
                	ROUND(coalesce(SUM(c.weight)FILTER(where c.weight_unit = 0) +
                	SUM(c.weight)FILTER(where c.weight_unit = 1)*0.4536, 0),1) as total_weight_kg
                from flight f
                left join cargo c on c.flight_id = f.id
                where date(f.departure_date) = :depDate and f."number" = :flightNumber
                group by f.id
                """, "CargoInfoDTO");
                query.setParameter("depDate", date);
                query.setParameter("flightNumber", flightNumber);
                query.unwrap(org.hibernate.query.Query.class);
                Object result = query.getSingleResult();
                return (CargoInfoDTO) result;
    }

    @Override
    public FlightInfoDTO findAggregateFlightInfo(Date date, String airportCode) {
        Query query = entityManager.createNativeQuery("""
                select
                    COUNT(distinct f.id) FILTER(where f.departure_airport = :airportCode) as departure_flights_count,
                    COUNT(distinct f.id) FILTER(where f.arrival_airport  = :airportCode) as arrival_flights_count,
                    COALESCE(SUM(c.pieces)FILTER(where f.departure_airport = :airportCode),0) as departure_baggage_pieces,
                    COALESCE(SUM(c.pieces)FILTER(where f.arrival_airport  = :airportCode),0) as arrival_baggage_pieces
                  from flight f
                  left join cargo c on c.flight_id = f.id
                  where date(f.departure_date) = :depDate and (f.arrival_airport  = :airportCode or f.departure_airport = :airportCode)\s
                  group by f.id
                """, "FlightInfoDTO");
        query.setParameter("depDate", date);
        query.setParameter("airportCode", airportCode);
        query.unwrap(org.hibernate.query.Query.class);
        Object result = query.getSingleResult();
        return (FlightInfoDTO) result;
    }


    /**
     * Additional special class for mapping sql result set to DTO
     */
    @SqlResultSetMappings({
            @SqlResultSetMapping(name= "CargoInfoDTO", classes = {
            @ConstructorResult(targetClass = CargoInfoDTO.class,
                    columns = {
                            @ColumnResult(name="sum_cargo_weight_kg",type = Float.class),
                            @ColumnResult(name="sum_baggage_weight_kg",type = Float.class),
                            @ColumnResult(name="total_weight_kg",type = Float.class)
                    }
            )
    }), @SqlResultSetMapping(name= "FlightInfoDTO", classes = {
            @ConstructorResult(targetClass = FlightInfoDTO.class,
                    columns = {
                            @ColumnResult(name="departure_flights_count",type = Long.class),
                            @ColumnResult(name="arrival_flights_count",type = Long.class),
                            @ColumnResult(name="departure_baggage_pieces",type = Long.class),
                            @ColumnResult(name="arrival_baggage_pieces",type = Long.class)
                    }
            )
    })}) @Entity class SQLMappingCfgEntity{@Id int id;} // <- workaround

}

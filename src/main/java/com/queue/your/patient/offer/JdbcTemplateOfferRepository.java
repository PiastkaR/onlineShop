//package com.queue.your.patient.offer;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Pageable;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Optional;
//
//@RequiredArgsConstructor
//public class JdbcTemplateOfferRepository implements OfferRepository {
//
//    private static final OfferRowMapper OFFER_ROW_MAPPER = new OfferRowMapper();
//    private final JdbcTemplate jdbcTemplate;
//
//    @Override
//    public Offer save(Offer offer) {
//        jdbcTemplate.update("insert into offers (id, calories_needed, variant) values (?, ?, ?)", offer.getId(), offer.getCaloriesNeed(), offer.getVariant());
//        return offer;
//    }
//
//    @Override
//    public List<Offer> findAll(Pageable pageable) {
//        return jdbcTemplate.query("select id, calories_needed, variant from offers", OFFER_ROW_MAPPER);
//    }
//
//    @Override
//    public Optional<Offer> findById( long id) {
//        return Optional.ofNullable(jdbcTemplate.queryForObject("select id, calories_needed, variant from offers where id = ?", OFFER_ROW_MAPPER, id));
//    }
//
//    private static class OfferRowMapper implements RowMapper<Offer> {
//        @Override
//        public Offer mapRow(ResultSet rs, int i) throws SQLException {
//            return new Offer(rs.getLong("id"), rs.getInt("calories_needed"), rs.getString("variant"));
//        }
//    }
//}

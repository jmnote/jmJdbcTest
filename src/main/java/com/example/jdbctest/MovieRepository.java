package com.example.jdbctest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MovieRepository {
	@Autowired NamedParameterJdbcTemplate jdbcTemplate;

	private static final RowMapper<Movie> movieRowMapper = (rs, i) -> {
		Integer id = rs.getInt("id");
		String title = rs.getString("title");
		String image = rs.getString("image");
		Integer year = rs.getInt("year");
		String plot = rs.getString("plot");
		return new Movie(id, title, image, year, plot);
	};

	public List<Movie> findAll() {
		return jdbcTemplate.query("SELECT id, title, image, year, plot FROM movie", movieRowMapper);
	}
}

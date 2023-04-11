package br.com.fiap.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.MarcaModel;

@Repository
public class MarcaRepository {
	
	private static final String GET_ALL = "SELECT * FROM TB_MARCA";
	private static final String GET = "SELECT * FROM TB_MARCA WHERE ID_MARCA=?";
	private static final String SAVE = "INSERT INTO TB_MARCA (NOME_MARCA) VALUES (?)";
	private static final String UPDATE = "UPDATE TB_MARCA SET NOME_MARCA=? WHERE ID_MARCA=?";
	private static final String DELETE = "DELETE FROM TB_MARCA WHERE ID_MARCA=?";
	
	@Autowired
	public JdbcTemplate jdbcTemplate;

	public MarcaRepository() {
		super();
	}
	
	public List<MarcaModel> findAll(){
		List<MarcaModel> marcas = this.jdbcTemplate.query(GET_ALL,
				new BeanPropertyRowMapper<MarcaModel>(MarcaModel.class));
		return marcas;
	}
	
	public MarcaModel findById(long id) {
		MarcaModel marca = this.jdbcTemplate.queryForObject(GET, 
				new BeanPropertyRowMapper<MarcaModel>(MarcaModel.class), id);
		return marca;
	}

	public void save(MarcaModel marcaModel) {
		this.jdbcTemplate.update(SAVE, marcaModel.getNomeMarca());
	}

	public void update(MarcaModel marcaModel) {
		this.jdbcTemplate.update(UPDATE, marcaModel.getNomeMarca(), marcaModel.getIdMarca());
	}

	public void deleteById(long id) {
		this.jdbcTemplate.update(DELETE, id);
	}

}

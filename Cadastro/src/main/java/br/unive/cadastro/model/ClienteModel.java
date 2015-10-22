package br.unive.cadastro.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ClienteModel extends AbstractTableModel {

	ClienteDaoH2Impl cdaoi = new ClienteDaoH2Impl();
	
	List<Cliente> lista = cdaoi.listar();
		

	@Override
	public int getRowCount() {
		
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		
		return 6;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Cliente c = lista.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return c.getId();
		case 1:
			return c.getNome();
		case 2:
			return c.getEndereço();
		case 3:
			return c.getTelefone();
		case 4:
			return c.getCidade();
		case 5:
			return c.getUf();
		
		default:
			return "invalido";
		}
		
	}

}

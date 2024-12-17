package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece pieces[][];
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error  creating  board: there must be  at least 1 row and 1 column ");
		}
		this.rows = rows;
		this.columns = columns;
		this.pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position p) {
		if(!positionExists(p)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[p.getRow()][p.getColunm()];
	}
	
	public void placePiece(Piece piece, Position position) {
		
		if(thereSsAPiece(position)) {
			throw new BoardException("There is already a piecie on position " + position);
		}
		pieces[position.getRow()][position.getColunm()] = piece;
		piece.position = position;
		
	}
	
	public Piece removePiece(Position p) {
		if(!positionExists(p)) {
			throw new BoardException("Position not on the board");
		}
		if(piece(p) == null) {
			return null;
		}
		Piece aux = piece(p);
		aux.position = null;
		pieces[p.getRow()][p.getColunm()] = null;
		return aux;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >=0 && column < columns;
	}
	
	public boolean positionExists(Position p) {
		return positionExists(p.getRow(), p.getColunm());
	}
	
	public boolean thereSsAPiece(Position p) {
		if(!positionExists(p)) {
			throw new BoardException("Position not on the board");
		}
		return piece(p) != null;
		
	}
	
				
	
	
	
	
	
}

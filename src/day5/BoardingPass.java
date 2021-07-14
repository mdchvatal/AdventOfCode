package day5;

public class BoardingPass implements Comparable<BoardingPass>{
	int column;
	int row;
	int seatId;
	
	public BoardingPass() {
		
	}
	
	public BoardingPass(int column, int row, int seatId) {
		this.column = column;
		this.row = row;
		this.seatId = seatId;
	}
	
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	@Override
	public int compareTo(BoardingPass pass1) {
		return (this.getSeatId() - pass1.getSeatId());
	}
	
	
}

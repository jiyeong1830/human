package JavaProject;

import java.io.*;

public class Word implements Serializable{
	private int pno;
	private String word;
	private String type;
	private String mean;
	private int date;

	public Word() {
	}
	
	public Word(String word, String type, String mean, int date) {
		this.word = word;
		this.type = type;
		this.mean = mean;
		this.date = date;
	}
	
	public int getPno() { return pno; }
	public void setPno(int pno) { this.pno = pno; }
	public String getWord() { return word; }
	public void setWord(String word) { this.word = word; }
	public String getType() { return type; }
	public void setType(String type) { this.type= type; }
	public String getMean() { return mean; }
	public void setMean (String mean) { this.mean = mean; }
	public int getDate() { return date; }
	public void setDate(int date) { this.date = date; }
}
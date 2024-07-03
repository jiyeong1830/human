package JavaProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import JavaProject.Word;

public class WordStorage {
	private List<Word> list = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	private int counter;
		
	public void showMenu() {
		while(true) {
			System.out.println("---------------------------------------------");
			System.out.println("1.등록 | 2.목록 | 3.수정 | 4.삭제 | 5.파일저장 |6.종료");
			System.out.println("---------------------------------------------");
				
			System.out.print("선택: ");
			String selectNo = scanner.nextLine();
			switch(selectNo) {
				case "1": registerWord(); break;
				case "2": showWord(); break;
				case "3": updateWord(); break;
				case "4": deleteWord(); break;
				case "5": fileProtect(); break;
				case "6": return;
			}
		}
	}
	

	public void registerWord() {
		try {
			Word word = new Word();
			word.setPno(++counter);
			
			System.out.print("단어: ");
			word.setWord(scanner.nextLine());
			
			System.out.print("단어 타입: ");
			word.setType(scanner.nextLine());
			
			System.out.print("뜻: ");
			word.setMean(scanner.nextLine());
			
			list.add(word);
			} catch(Exception e) {
				System.out.println("등록할 수 없습니다;" + e.getMessage());
		}
	}
	
	public void showWord() {
		for(Word p : list) {
			System.out.println(p.getPno() + "\t" + p.getWord() + "\t" + p.getType() + "\t" + p.getMean());
		}
	}
	
	public void updateWord() {
		System.out.print("수정할 단어의 번호: ");
        int pno = Integer.parseInt(scanner.nextLine());

        for (Word p : list) {
            if (p.getPno() == pno) {
                System.out.print("수정할 단어: ");
                p.setWord(scanner.nextLine());
                System.out.print("수정할 단어의 타입: ");
                p.setType(scanner.nextLine());
                System.out.print("수정할 단어의 뜻: ");
                p.setType(scanner.nextLine());
                return;
            }
        }
	}
	
	public void deleteWord() {
		System.out.print("삭제할 단어의 번호: ");
        int pno = Integer.parseInt(scanner.nextLine());

        for (Word p : list) {
            if (p.getPno() == pno) {
                list.remove(p);
                return;
            }
        }
	}
	
	public void fileProtect() {
		try {
			writeList();
			List<Word> list = readList();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for(Word word : list) {
				System.out.println(
					word.getPno() + "\t" + word.getWord() + "\t" +
					word.getType() + "\t" + word.getMean() + "\t"
				);
			}
		} catch (Exception e)  {
			e.printStackTrace();
			System.out.println("저장할 수 없습니다;" + e.getMessage());
		}
	}

	public void writeList() throws Exception {		
		FileOutputStream fos = new FileOutputStream("bin/JavaProject/words.db");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.flush();
		oos.close();
		
	}
	
	public List<Word> readList() throws Exception {
		FileInputStream fis = new FileInputStream("bin/JavaProject/words.db");
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<Word> list = (List<Word>) ois.readObject();
		ois.close();
		return list;
	}
}
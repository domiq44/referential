package referential.app;

import java.util.List;
import java.util.Scanner;

import referential.dao.impl.DataDaoImpl;
import referential.entity.Data;

public class Presentation {

	public static void main(String[] args) throws Exception {
		final Scanner keyboard = new Scanner(System.in);
		System.out.println("Key: ");
		final String key = keyboard.nextLine();
		keyboard.close();
		final DataDaoImpl dao = new DataDaoImpl();
		final List<Data> datas = dao.getDataByKey(key);
		for (final Data data : datas) {
			System.out.println(data);
		}
	}

}

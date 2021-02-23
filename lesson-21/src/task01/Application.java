package task01;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;

public class Application {

	public static void main(String[] args) {

		File file = new File("File.txt");

		try {
			getAnnotationValue(Person.class, file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	public static void getAnnotationValue(Class<?> customClass, File file) throws FileNotFoundException {

		Field[] fields = customClass.getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];

			if (field.getAnnotation(AnnotationInfo.class) instanceof AnnotationInfo) {
				System.out.print(field.getName() + " ----- ");
				System.out.println("Annotation value = " + field.getAnnotation(AnnotationInfo.class).param());
			}
		}
	}

}
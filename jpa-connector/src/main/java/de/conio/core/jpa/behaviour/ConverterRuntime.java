package de.conio.core.jpa.behaviour;

import java.lang.reflect.Method;

import de.conio.core.jpa.structure.user.UserEntity;
import de.conio.core.structure.User;

public class ConverterRuntime {

	public static void main(String[] args) {
		// Entity 2 Model
		String name = User.class.getSimpleName();
		Method[] methods = UserEntity.class.getMethods();

		System.out.println("public class " + name + "Mapper{");
		System.out.println();
		System.out.println("public static " + name + " convert2" + name + " (" + name + "Entity entity) {");
		System.out.println(name + " " + name.toLowerCase() + " = new " + name + "();");
		for (Method object : methods) {
			if (object.getName().contains("set")) {
				System.out.println(name.toLowerCase() + "." + object.getName() + "(entity." + "get"
						+ object.getName().substring(3, object.getName().length()) + "());");
			}
		}
		System.out.println("return entity;");
		System.out.println("}");
		
		
		System.out.println();

		// Non-Entity Model 2 Entity
		System.out.println("public static " + name + "Entity convert2" + name + "Entity (" + name + " " + name.toLowerCase() + ") {");
		System.out.println(name + "Entity " + name.toLowerCase() + "Entity = new " + name + "Entity();");
		for (Method object : methods) {
			if (object.getName().contains("set")) {
				System.out.println(name.toLowerCase() + "Entity." + object.getName() + "(" + name.toLowerCase() + "." + "get"
						+ object.getName().substring(3, object.getName().length()) + "());");
			}
		}
		System.out.println("return "+ name.toLowerCase() + "Entity;");
		System.out.println("}");
		
		System.out.println("}");

	}
}

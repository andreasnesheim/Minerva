package Connection;

import java.io.File;
import java.util.regex.Pattern;

public class Testsdfds {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pathname = "C:\\Users\\Andy\\Desktop\\MinervaWorkspace\\Minerva\\Minerva\\WebContent\\img";
		
		System.out.println(pathname);
		int index = pathname.lastIndexOf('\\');
		String asdaksd = pathname.substring(index+1, pathname.length());
		System.out.println(asdaksd);
		String imagePathInProject = "img\\profile\\";
		System.out.println(imagePathInProject);
		
		
	}

}

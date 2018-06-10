package inheritan;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrintKids implements HumanIF {

	@Override
	public void printInfo(Class<? extends Human> huClz, Human huObj){
		// TODO Auto-generated method stub

			Method kidSetter = null;
			Method kidGetter = null;
			try {
				kidSetter = huClz.getMethod("setFavoriteDolls", String.class);
				kidSetter.invoke(huObj, "robot");
				kidGetter = huClz.getMethod("getFavoriteDolls");
				System.out.println(kidGetter.invoke(huObj));
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}

}

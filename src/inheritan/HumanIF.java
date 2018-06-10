/**
 * 
 */
package inheritan;

import java.lang.reflect.InvocationTargetException;

/**
 * @author cleve
 *
 */
public interface HumanIF {
 public default void printInfo(Human human) {
	 Class<? extends Human> huClz = human.getClass();
	 try {
		Human huObj = huClz.getConstructor().newInstance();
		printInfo(huClz, huObj);
	} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
			| NoSuchMethodException | SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }

abstract public void printInfo(Class<? extends Human> huClz, Human huObj);
}

package rs.math.oop1.z140500.ispitivanjeZabeleski.z01.opisVerzija;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Specifying runtime retention policy
@Retention( RetentionPolicy.RUNTIME )
// Specifying target
@Target( { ElementType.METHOD, ElementType.TYPE } )
@interface Description
{
	String author() default "Vlado";
	
	String date();
}
/*
 * Created on 2004.4.21
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package v13.v08BDrvo;

/**
 * @author Ja
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TestBTree 
{ 
			public static void main( String args[] ) 
			{ 
				 String keys[] = {  
					 "A", "B", "C", "D", "E", "F", "G", "H",  
					 "I", "J", "K", "L", "M", "N", "O", "P",  
					 "Q", "R", "S", "T", "U", "V", "W", "X", 
					 "Y", "Z", "ZA", "YA", "UA", "XA", "WA",  
					 "VA", "TA", "SA", "RA", "QA", "PA", "OA",  
					 "NA", "MA", "LA", "KA", "JA", "IA", "HA",  
					 "GA", "FA", "EA", "DA", "CA", "BA", "AA" }; 
 
				 BTree t = new BTree( 6, 
						 new Comparable() 
						 { 
									 public int compare( Object a, Object b )  
									 { 
											 return ((String)a).compareTo( 
														(String)b ); 
									 } 
							 }  
						 ); 
    
					 for( int i = 0; i < keys.length; i++ ) 
					 { 
						 t.add(keys[i]); 
					 } 
    
					 t.traverse( BTree.INORDER, 
							 new Traversal() 
							 { 
									public void process(Object o) 
									{ 
											System.out.println( o ); 
									} 
							} 
					); 
			} 
}  						 	
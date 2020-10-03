/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
***/
package rs.math.oop1.z180304.filterMapReduce.z08.assetsSumiranje;

public class Asset
{
	public enum AssetType
	{
		BOND, STOCK
	};
	
	private final AssetType type;
	private final int value;
	
	public Asset( final AssetType assetType, final int assetValue )
	{
		type = assetType;
		value = assetValue;
	}
	
	public AssetType getType()
	{
		return type;
	}
	
	public int getValue()
	{
		return value;
	}
}

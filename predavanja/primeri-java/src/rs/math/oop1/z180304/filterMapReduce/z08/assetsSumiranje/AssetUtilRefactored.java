package rs.math.oop1.z180304.filterMapReduce.z08.assetsSumiranje;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AssetUtilRefactored
{
	public static int totalAssetValues( final List<Asset> assets,
			final Predicate<Asset> assetSelector )
	{
		return assets.stream().filter( assetSelector ).mapToInt( Asset::getValue )
				.sum();
	}
	
	public static void main( final String[] args )
	{
		List<Asset> assets = Arrays.asList( new Asset( Asset.AssetType.BOND, 1000 ),
				new Asset( Asset.AssetType.BOND, 2000 ),
				new Asset( Asset.AssetType.STOCK, 3000 ),
				new Asset( Asset.AssetType.STOCK, 4000 ) );
				
		System.out.println(
				"Total of all assets: " + totalAssetValues( assets, asset -> true ) );
				
		System.out.println( "Total of bonds: " + totalAssetValues( assets,
				asset -> asset.getType() == Asset.AssetType.BOND ) );
				
		System.out.println( "Total of stocks: " + totalAssetValues( assets,
				asset -> asset.getType() == Asset.AssetType.STOCK ) );
	}
}

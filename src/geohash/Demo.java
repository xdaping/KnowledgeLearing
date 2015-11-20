package geohash;

import ch.hsr.geohash.GeoHash;

public class Demo {

	public static void main(String args[]) {
                
        //test1(39.69731931820395,116.06873609678199);
        
        //test2();
		
		test3("wx4en6");
    }	

	private static void test3(String geohashStr) {
		GeoHash geohash = GeoHash.fromGeohashString(geohashStr);
		
		System.out.println("格子中心："+geohash.getBoundingBoxCenterPoint());
		
		test1(geohash.getBoundingBoxCenterPoint().getLatitude(),
				geohash.getBoundingBoxCenterPoint().getLongitude());
	}

	private static void test2() {
		GeoHash geoHash = GeoHash.withCharacterPrecision(39.69731931820395,116.06873609678199, 6);
		System.out.println(geoHash.toString());
		System.out.println(geoHash.getBoundingBox().getLatitudeSize());
		geoHash = GeoHash.withCharacterPrecision(39.69731931820395+0.003,116.06873609678199+0.003, 6);
		System.out.println(geoHash.toString());
		geoHash = GeoHash.withCharacterPrecision(39.69731931820395+0.005,116.06873609678199-0.003, 6);
		System.out.println(geoHash.toString());
		geoHash = GeoHash.withCharacterPrecision(39.69731931820395-0.003,116.06873609678199+0.003, 6);
		System.out.println(geoHash.toString());
		geoHash = GeoHash.withCharacterPrecision(39.69731931820395-0.003,116.06873609678199-0.003, 6);
		System.out.println(geoHash.getBoundingBox().getLatitudeSize());
		
		
	}

	


	private static void test1(double lat, double lng) {
		GeoHash geoHash = GeoHash.withCharacterPrecision(lat, lng, 6);       
        
        System.out.println(geoHash.toString());
        System.out.println("格子号："+geoHash.toBase32());
        System.out.println("格子中心："+geoHash.getBoundingBoxCenterPoint());
        System.out.println("格子边界："+geoHash.getBoundingBox());
        
        for (GeoHash one : geoHash.getAdjacent()) {
            System.out.println(one.toString());
        }
		
	}
	
	

}

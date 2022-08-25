package ibu.edu.homework;
import java.io.IOException;
public class App {
	public static void main(String[] args) throws IOException {
		IPaddress[] ipAddress = new IPaddress[4600000];
		long start=System.currentTimeMillis();
		ipAddress = IPaddress.readNumbers("/Users/acaus/Downloads/IP-COUNTRY-REGION-CITY-SHUFFLED/IP-COUNTRY-REGION-CITY-SHUFFLED.csv");
		HeapSort.sort(ipAddress);
		System.out.println((System.currentTimeMillis()-start)+ " ms");
		IPaddress.writeToFile("/Users/acaus/Downloads/heapsort.csv", ipAddress);
			}
		}



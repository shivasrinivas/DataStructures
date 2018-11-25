using System;
using System.Text;

namespace Distance {
	class HammingDistance {
		static void Main() {
			Console.WriteLine(CalculateHammingDistance(1, 4));
			Console.WriteLine(CalculateHammingDistance(93, 73));
			Console.WriteLine(CalculateHammingDistance(3, 1));
		}

		public static int CalculateHammingDistance(int x, int y) {
			if(x == y) {
				return 0;
			}
			string xBinary = GetBinaryString(x);
			string yBinary = GetBinaryString(y);
			int xIndex = xBinary.LastIndexOf("1");
			int yIndex = yBinary.LastIndexOf("1");

			Console.WriteLine(xBinary);
			Console.WriteLine(yBinary);
			Console.WriteLine(xIndex);
			Console.WriteLine(yIndex);

			while(xIndex == yIndex) {
				if(xBinary.LastIndexOf("1", xIndex - 1) != -1) {
					xIndex = xBinary.LastIndexOf("1", xIndex - 1);	
				}
				
				yIndex = yBinary.LastIndexOf("1", yIndex - 1);
				Console.WriteLine(xIndex);
				Console.WriteLine(yIndex);
			}

			int hammingDistance = 0;

			if(xIndex > yIndex) {
				hammingDistance = xIndex - yIndex;
			} else {
				hammingDistance = yIndex - xIndex;
			}

			return hammingDistance;
		}

		public static string GetBinaryString(int x) {
			char[] sb = {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'
			,'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',};
			int i = 31;
			while(x > 0) {
				if(x % 2 != 0) {
					sb[i] = '1';
				} 
				x /= 2;
				i--;
			}

			return new string(sb);
		}
	}
}

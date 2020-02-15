
public class AddBinary {

	public static void main(String[] args) {
		AddBinary addBinary = new AddBinary();
		System.out.println(addBinary.addBinary("0", "1"));
	}

	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = 0;

			if (i >= 0 && a.charAt(i) == '1') {
				sum++;
			}
			if (j >= 0 && b.charAt(j) == '1') {
				sum++;
			}
			sum += carry;
			if (sum >= 2) {
				carry = 1;
			} else {
				carry = 0;
			}
			sb.insert(0, (char) ((sum % 2) + '0'));
			System.out.println((char) ((sum % 2) + '0'));
			i--;
			j--;
		}
		if (carry == 1)
			sb.insert(0, '1');

		return sb.toString();
	}
    // consider two binary string
    public String addBinary2(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        
        int lenA = charA.length -1;
        int lenB = charB.length -1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(lenA>= 0 || lenB>= 0){
            int tempA = (lenA>= 0)? charA[lenA] -'0':0;
            int tempB = (lenB>= 0)? charB[lenB] -'0':0;
            int sum = carry + tempA +tempB;
            sb.append(sum%2);
            carry = sum/2;
            lenA --;
            lenB --;
        }
        if(carry == 1) sb.append("1");
        return sb.reverse().toString();
    }
}

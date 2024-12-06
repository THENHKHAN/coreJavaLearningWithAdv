package kunalSeries.stringassignment.easy;

// TODO: 1108. Defanging an IP Address
// https://leetcode.com/problems/defanging-an-ip-address/description/
public class _4_DefangingIpAddressVeryEasy {

    public static  String defangIPaddr(String address) {
        String defangVersion = address.replace(".", "[.]");
        return defangVersion;
    }

    public static void main(String[] args) {
//       String  address = "1.1.1.1"; // "1[.]1[.]1[.]1"
       String  address = "255.100.50.0"; // "255[.]100[.]50[.]0"

        System.out.println("Origina IPv4 Address : " + address + " & its Defange address : " + defangIPaddr(address));
    }
}

// The replace() method processes each character in the string once, where N is the length of the input string.
// Hence TC: O(N) , SC: O(N)
// ALso U can use String Builder and append [.] at the palce of . after converting String to CharArray. So that U can find . as char and so that .
// But this things i have done -  It is the most straightforward and optimal solution for this problem!
// U can read this as well : https://leetcode.com/problems/defanging-an-ip-address/solutions/5935363/java-achieves-100-easy-and-simple-approach/
/*
public String defangIPaddr(String address) {
    StringBuilder defangVersion = new StringBuilder();
    for (char c : address.toCharArray()) {
        if (c == '.') {
            defangVersion.append("[.]");
        } else {
            defangVersion.append(c);
        }
    }
    return defangVersion.toString();
}
*/

// TODO : Extra - if validation needed : For the defanging problem specifically, invalid inputs would simply cause undefined behavior unless explicitly handled.
// How to Handle Invalid Cases:
/*
public boolean isValidIPv4(String address) {
    String[] segments = address.split("\\.");
    if (segments.length != 4) return false;
    for (String segment : segments) {
        if (segment.isEmpty() || !segment.matches("\\d+") || Integer.parseInt(segment) > 255 || Integer.parseInt(segment) < 0) {
            return false;
        }
    }
    return true;
    If input validation is required, you could:

Split the string by periods and check:
        The number of segments is exactly 4.
        Each segment is numeric and within the range 0-255.
Reject addresses with invalid characters or incorrect formats.
}
 */

/*
QUESTION:
Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".

 */
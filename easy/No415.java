class Solution {
    char[] sum = new char[5105]; 
    int n = 5104;
    String a, b;
    
    public String addStrings(String a, String b) {
        if(a == null && b == null) return "0";
        else if(a == null) return b;
        else if (b == null) return a;
        this.a = a; this.b = b;
        
        add(a.length() - 1, b.length()- 1, 0);
        String ret = "";
        int i = 0;
        while(i < 5104 && sum[i] == 0) i++;
        for(; i < 5105; i++) ret += sum[i];
        return ret;
    }
    
    void add(int ia, int ib, int carry){
        if(ia < 0 && ib < 0 && carry == 0) return;
        int s = carry;
        if(ia >= 0) s += a.charAt(ia) - '0';
        if(ib >= 0) s += b.charAt(ib) - '0';
        sum[n--] = (char)(s % 10 + '0');
        add(ia - 1, ib - 1, s / 10);
    }
}

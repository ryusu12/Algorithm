class Solution {
    public int[] solution(String[] wallpaper) {
        int minlux = wallpaper.length + 1;
        int minluy = wallpaper[0].length();
        int maxrdx = 0;
        int maxrdy = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                if (minlux > i) minlux = i;
                if (maxrdx < i) maxrdx = i;
            }
            int idx = -1;
            while (wallpaper[i].contains("#") && idx < wallpaper[i].length()) {
                idx = wallpaper[i].indexOf("#", idx + 1);
                if (idx == -1) break;
                if (minluy > idx) minluy = idx;
                if (maxrdy < idx) maxrdy = idx;
            }
        }
        if (minlux == wallpaper.length + 1) minlux = 0;
        if (minluy == wallpaper.length + 1) minluy = 0;
        return new int[] {minlux, minluy, maxrdx + 1, maxrdy + 1};
    }
}
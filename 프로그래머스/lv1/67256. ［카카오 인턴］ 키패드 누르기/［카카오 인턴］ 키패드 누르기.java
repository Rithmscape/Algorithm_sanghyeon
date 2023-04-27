class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuffer sb = new StringBuffer();
        int[] point = {10, 12};

        for (int i = 0; i < numbers.length; i++) {
            int key = numbers[i];
            if (key == 1 | key == 4 | key == 7) {
                sb.append("L");
                point[0] = key;
            } else if (key == 3 | key == 6 | key == 9) {
                sb.append("R");
                point[1] = key;
            } else {
                if (key == 0) {
                    key = 11;
                }

                int leftDistance = Math.abs(key - point[0]);
                int rightDistance = Math.abs(key - point[1]);

                leftDistance = (leftDistance / 3) + (leftDistance % 3);
                rightDistance = (rightDistance / 3) + (rightDistance % 3);

                if (leftDistance < rightDistance) {
                    sb.append("L");
                    point[0] = key;
                } else if (leftDistance > rightDistance) {
                    sb.append("R");
                    point[1] = key;
                } else {
                    if ("left".equals(hand)) {
                        sb.append("L");
                        point[0] = key;
                    } else {
                        sb.append("R");
                        point[1] = key;
                    }
                }
            }
        }
        return sb.toString();
    }
}
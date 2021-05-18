class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String ,List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] splitPaths = path.split(" ");
            for (int i = 1 ; i < splitPaths.length; i++) {
                int bracketIndex = splitPaths[i].indexOf("(");
                String filePath = splitPaths[0] + "/" + splitPaths[i].substring(0, bracketIndex);
                String contents = splitPaths[i].substring(bracketIndex, splitPaths[i].length() - 1);
                map.putIfAbsent(contents, new ArrayList<>());
                map.get(contents).add(filePath);
            }
        }
        List<List<String>> ret = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                ret.add(map.get(key));
            }
        }
        ret.sort(Comparator.comparingInt(strings -> -strings.size()));
        return ret;
    }
}
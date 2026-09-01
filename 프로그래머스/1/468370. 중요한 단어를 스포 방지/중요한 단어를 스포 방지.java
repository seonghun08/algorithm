import java.util.*;

class Solution {
    public int solution(String message, int[][] ranges) {
        List<Word> words = getWords(message);
        Set<String> spoilerWords = new HashSet<>();
        Set<String> notSpoilerWords = new HashSet<>();
        
        for (Word word : words) {
            if (isSpoiler(word, ranges)) {
                spoilerWords.add(word.text);
            } else {
                notSpoilerWords.add(word.text);
            }
        }
        
        int answer = 0;
        for (String text : spoilerWords) {
            if (!notSpoilerWords.contains(text)) {
                answer++;
            }
        }
        return answer;
    }
    
    private boolean isSpoiler(Word word, int[][] ranges) {
        for (int[] range : ranges) {
            if (word.start <= range[1] && word.end >= range[0]) {
                return true;
            }
        }
        return false;
    }
    
    private List<Word> getWords(String message) {
        List<Word> words = new ArrayList<>();
        int len = message.length();
        int start = -1;
        for (int i = 0; i < len; i++) {
            if (message.charAt(i) != ' ' && start == -1) {
                start = i;
                continue;
            }
            if ((message.charAt(i) == ' ') && start != -1) {
                String text = message.substring(start, i);
                words.add(new Word(text, start, i - 1));
                start = -1;
                continue;
            }
            if (i == len - 1 && start != -1) {
                String text = message.substring(start, i + 1);
                words.add(new Word(text, start, i + 1));
            }
        }
        return words;
    }
    
    public static class Word {
        
        String text;
        int start;
        int end;
        
        public Word(String text, int start, int end) {
            this.text = text;
            this.start = start;
            this.end = end;
        }
    }
}

public class Word {
    private String engWord;
    private String rusWord;
    private String lesson;
	public Word(String engWord, String rusWord, String lesson) {
		super();
		this.engWord = engWord;
		this.rusWord = rusWord;
		this.lesson = lesson;
	}
	public Word() {
		super();
	}
	public String getEngWord() {
		return engWord;
	}
	public void setEngWord(String engWord) {
		this.engWord = engWord;
	}
	public String getRusWord() {
		return rusWord;
	}
	public void setRusWord(String rusWord) {
		this.rusWord = rusWord;
	}
	public String getLesson() {
		return lesson;
	}
	public void setLesson(String lesson) {
		this.lesson = lesson;
	}
}

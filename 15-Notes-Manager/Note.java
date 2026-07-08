public class Note {

    private int noteId;
    private String title;
    private String content;

    // Constructor
    public Note(int noteId, String title, String content) {
        this.noteId = noteId;
        this.title = title;
        this.content = content;
    }

    // Getters
    public int getNoteId() {
        return noteId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return noteId + "," + title + "," + content;
    }
}
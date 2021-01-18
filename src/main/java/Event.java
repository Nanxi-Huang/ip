class Event extends Task{
    protected boolean isDone;
    protected String time;
    protected final static String type = "[E]";

    public Event(String description, String time) {
        super(description);
        this.time = time;
        this.isDone = false;
    }

    public String getTime() {
        return this.time;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return getType() + super.toString() + " (at: " + getTime() + ")";
    }

}
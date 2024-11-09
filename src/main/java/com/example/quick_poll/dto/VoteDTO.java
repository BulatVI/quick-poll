package com.example.quick_poll.dto;

import com.example.quick_poll.model.Option;

public class VoteDTO {

    private long id;
    private Option option;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Option getOption() {
        return option;
    }
    public void setOption(Option option) {
        this.option = option;
    }
    @Override
	public String toString() {
		return getId() + ", " + getOption();
	}
}

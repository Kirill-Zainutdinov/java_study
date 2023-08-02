package HW_11.notebook.util.mapper;

import HW_11.notebook.model.User;

public interface Mapper {
    String toInput(User e);
    User toOutput(String str);
}

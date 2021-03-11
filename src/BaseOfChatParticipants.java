import javax.swing.*;
import java.sql.ResultSet;

import java.util.ArrayList;

public class BaseOfChatParticipants extends AbstractListModel <String> {
    private ArrayList <String> chatParticipants = new ArrayList <String>();

    public void setContacts(ResultSet rs, String column) {
        try {
            chatParticipants.clear();
            while (rs.next()) {
                synchronized (chatParticipants) {
                    chatParticipants.add(rs.getString(column));
                }
                fireIntervalAdded(this, 0, chatParticipants.size());
            }
            rs.close();
            fireContentsChanged(this, 0, chatParticipants.size());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getSize() {
        return chatParticipants.size();
    }

    @Override
    public String getElementAt(int index) {
        synchronized (chatParticipants) {
            return chatParticipants.get(index);
        }
    }
}

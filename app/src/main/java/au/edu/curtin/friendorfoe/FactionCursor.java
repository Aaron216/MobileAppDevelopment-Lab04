package au.edu.curtin.friendorfoe;

import au.edu.curtin.friendorfoe.FriendOrFoeSchema.FactionTable;
import android.database.Cursor;
import android.database.CursorWrapper;

public class FactionCursor extends CursorWrapper {
    public FactionCursor(Cursor cursor) {
        super(cursor);
    }

    public Faction getFaction() {
        int id = getInt(getColumnIndex(FactionTable.Cols.ID));
        String name = getString(getColumnIndex(FactionTable.Cols.NAME));
        int strength = getInt(getColumnIndex(FactionTable.Cols.STRENTH));
        int relationship = getInt(getColumnIndex(FactionTable.Cols.RELATIONSHIP));

        return new Faction(id, name, strength, relationship);
    }
}

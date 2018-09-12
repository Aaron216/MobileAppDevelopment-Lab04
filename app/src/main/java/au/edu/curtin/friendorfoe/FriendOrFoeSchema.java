package au.edu.curtin.friendorfoe;

public class FriendOrFoeSchema {
    public static class FactionTable {
        // Table Name
        public static final String NAME = "factions";
        // Column Names
        public static class Cols {
            public static final String ID = "faction_id";
            public static final String NAME = "name";
            public static final String STRENTH = "strength";
            public static final String RELATIONSHIP = "relationship";
        }
    }
}

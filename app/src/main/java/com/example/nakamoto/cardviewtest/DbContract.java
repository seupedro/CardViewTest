package com.example.nakamoto.cardviewtest;

import android.provider.BaseColumns;

public class DbContract {

    private DbContract(){}

    public static class AquaEntry implements BaseColumns{

        /* Table Constant */
        public static final String TEST_TABLE = "test";

        /* Columns Constants */
        public static final String _testID = BaseColumns._ID;
        public static final String NAME_COLUMN = "name";

    }
}

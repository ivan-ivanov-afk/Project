package com.SpeakFluently.api.SpeakFluently.system.operations;
import com.SpeakFluently.api.SpeakFluently.system.QueryProcessor;

public class UpdateQueryBuilder extends WhereQueryBuilder<UpdateQueryBuilder> {

    private QueryProcessor queryProcessor;
    private String tableName;

    public UpdateQueryBuilder(QueryProcessor queryProcessor, String tableName) {

        super(queryProcessor);
        this.queryProcessor = queryProcessor;
        this.tableName = tableName;

        this.queryProcessor.initNewQueryOperation();
        this.queryProcessor.getQueryBuilder().append("UPDATE ")
                .append(tableName)
                .append(" SET ");
    }

    public UpdateQueryBuilder set(String columName, Object value) {

        if(!this.queryProcessor.getColumnCollection().isEmpty()) {
            this.queryProcessor.getQueryBuilder().append(",");
        }

        this.queryProcessor.buildColumnValuePair(columName);
        this.queryProcessor.setQueryColumnValuePair(columName, value);
        return this;
    }

    public int update() {
        return this.queryProcessor.processQuery();
    }
}

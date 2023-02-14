package fr.inria.diverse.query;

import java.io.IOException;
import java.util.Set;

public interface IGraphQuery {
	public Set<Long> runQuery() throws IOException, InterruptedException;
}

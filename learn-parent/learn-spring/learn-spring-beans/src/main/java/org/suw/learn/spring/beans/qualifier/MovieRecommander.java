package org.suw.learn.spring.beans.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MovieRecommander {
	@Autowired
	@Qualifier("main")
	private SimpleMovieCatalog moveCatalog;
}

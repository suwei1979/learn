/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.pattern.analysis.specification;

/**
 * [Specified by Eric Evans and Martin Fowler]A specification is able to tell if an candidate object match some
 * criteria, and can be used for:<br>
 * <p>
 * <ol>
 * <li>Selection: You need to select a subset of objects based on some criteria, and to refresh the selection at various
 * <li>Validation: You need to check that only suitable objects are used for a certain purpose
 * <li>Construction-to-order: You need to describe what an object might do, without explaining the details of how the
 * object does it, but in such a way that a candidate might be built to fulfill the requirement
 * </ol>
 *
 * @author suwei
 */
public interface Specification {

}

package aima.core.agent.impl.aprog.simplerule;

import aima.core.agent.impl.ObjectWithDynamicAttributes;

/**
 * Implementation of an AND condition.
 * 
 * @author Ciaran O'Reilly
 * 
 */
public class ANDCondition4 extends Condition
{
  private Condition no1;
  private Condition no2;
  private Condition no3;
  private Condition no4;

  public ANDCondition4( Condition cond1, Condition cond2, Condition cond3,
      Condition cond4 )
  {
    assert ( null != cond1 );
    assert ( null != cond2 );
    assert ( null != cond3 );
    assert ( null != cond4 );

    no1 = cond1;
    no2 = cond2;
    no3 = cond3;
    no4 = cond4;
  }

  @Override
  public boolean evaluate( ObjectWithDynamicAttributes p )
  {
    return ( no1.evaluate( p ) && no2.evaluate( p ) && no3.evaluate( p ) && no4
        .evaluate( p ) );
  }

  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();

    return sb.append( "[" ).append( no1 ).append( " && " ).append( no2 )
        .append( " && " ).append( no3 ).append( " && " ).append( no4 )
        .append( "]" ).toString();
  }
}

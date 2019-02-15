/* Generated by: ParserGeneratorCC: Do not edit this line. SimpleCharStream.java Version 1.1 */
/* ParserGeneratorCCOptions:SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package pcgen.base.formula.parse;

/**
 * An implementation of interface CharStream, where the stream is assumed to
 * contain only ASCII characters (without unicode processing).
 */
public
class SimpleCharStream extends AbstractCharStream
{
  protected java.io.Reader inputStream;

  @Override
  protected int streamRead(final char[] buffer, final int offset, final int len) throws java.io.IOException {
    return inputStream.read (buffer, offset, len); 
  }
  
  @Override
  protected void streamClose() throws java.io.IOException {
    inputStream.close (); 
  }

  protected void fillBuff() throws java.io.IOException
  {
    if (maxNextCharInd == available)
    {
      if (available == bufsize)
      {
        if (tokenBegin > 2048)
        {
          maxNextCharInd = 0;
          bufpos = 0;
          available = tokenBegin;
        }
        else
        if (tokenBegin < 0) {
          maxNextCharInd = 0;
          bufpos = 0;
        }
        else
          expandBuff(false);
      }
      else
      if (available > tokenBegin)
        available = bufsize;
      else
      if ((tokenBegin - available) < 2048)
        expandBuff(true);
      else
        available = tokenBegin;
    }

    try {
      final int i = inputStream.read(buffer, maxNextCharInd, available - maxNextCharInd);
      if (i == -1)
      {
        inputStream.close();
        throw new java.io.IOException();
      }
      maxNextCharInd += i;
      return;
    }
    catch(java.io.IOException e) {
      --bufpos;
      backup(0);
      if (tokenBegin == -1)
        tokenBegin = bufpos;
      throw e;
    }
  }

  /** Read a character. */
  public char readChar() throws java.io.IOException
  {
    if (inBuf > 0)
    {
      --inBuf;

      if (++bufpos == bufsize)
        bufpos = 0;

      return buffer[bufpos];
    }

    ++bufpos;
    if (bufpos >= maxNextCharInd)
      fillBuff();

    char c = buffer[bufpos];

    if (isTrackLineColumn())
      updateLineColumn(c);
    return c;
  }

  /** Constructor. */
  public SimpleCharStream(final java.io.Reader dstream,
                          final int startline,
                          final int startcolumn, 
                          final int buffersize)
  {
    super (startline, startcolumn, buffersize);
    inputStream = dstream;
  }

  /** Constructor. */
  public SimpleCharStream(final java.io.Reader dstream,
                          final int startline,
                          final int startcolumn)
  {
    this(dstream, startline, startcolumn, 4096);
  }

  /** Constructor. */
  public SimpleCharStream(final java.io.Reader dstream)
  {
    this(dstream, 1, 1, 4096);
  }

  /** Reinitialise. */
  public void reInit(final java.io.Reader dstream)
  {
    reInit(dstream, 1, 1, 4096);
  }

  /** Reinitialise. */
  public void reInit(final java.io.Reader dstream, 
                     final int startline,
                     final int startcolumn)
  {
    reInit(dstream, startline, startcolumn, 4096);
  }

  /** Reinitialise. */
  public void reInit(final java.io.Reader dstream, 
                     final int startline,
                     final int startcolumn, 
                     final int buffersize)
  {
    inputStream = dstream;
    super.reInit (startline, startcolumn, buffersize);
  }
  
  /** Constructor. */
  public SimpleCharStream(final java.io.InputStream dstream, 
                          final java.nio.charset.Charset encoding, 
                          final int startline,
                          final int startcolumn,
                          final int buffersize) 
  {
    this(new java.io.InputStreamReader(dstream, encoding), startline, startcolumn, buffersize);
  }

  /** Constructor. */
  public SimpleCharStream(final java.io.InputStream dstream,
                          final java.nio.charset.Charset encoding, 
                          final int startline,
                          final int startcolumn)
  {
    this(dstream, encoding, startline, startcolumn, 4096);
  }

  /** Constructor. */
  public SimpleCharStream(final java.io.InputStream dstream, 
                          final java.nio.charset.Charset encoding)
  {
    this(dstream, encoding, 1, 1, 4096);
  }

  /** Reinitialise. */
  public void reInit(final java.io.InputStream dstream, 
                     final java.nio.charset.Charset encoding)
  {
    reInit(dstream, encoding, 1, 1, 4096);
  }

  /** Reinitialise. */
  public void reInit(final java.io.InputStream dstream, 
                     final java.nio.charset.Charset encoding, 
                     final int startline,
                     final int startcolumn)
  {
    reInit(dstream, encoding, startline, startcolumn, 4096);
  }

  /** Reinitialise. */
  public void reInit(final java.io.InputStream dstream, 
                     final java.nio.charset.Charset encoding, 
                     final int startline,
                     final int startcolumn, 
                     final int buffersize)
  {
    reInit(new java.io.InputStreamReader(dstream, encoding), startline, startcolumn, buffersize);
  }
}
/* ParserGeneratorCC - OriginalChecksum=8c04be9264b472b25f26ec6ddd3d349f (do not edit this line) */


import java.io.*;



/** class wc emulates (a subset of) the Unix wc command.
    <p>Usage java wc file [ file ... ]
    <p>Prints the number of lines, the number of words, and the number
    of characters.  If more than one file is specified, it also prints
    the totals following the output for each file.
    <br>The Unix wc flags -w, -l, and -c are not recognized.
 */



class wc
{
	/** right justifies string "s" in a field "width" characters wide.
	    Pads on the left with blanks.
	  */

	public static String rightJustify(String s, int width)
	{	String	format = "";

		for (int i = 0; i < width - s.length(); i++)
			format += " ";

		return format + s;
	}



	public static void main(String args[]) throws IOException
	{
		int	t_lines = 0;	     // total number of lines
		int	t_words = 0;	     // total number of words
		int	t_chars = 0;	     // total number of characters

		if (args.length < 1)
		{	System.err.println("USAGE: wc file [ file ... ]");
			System.exit(1);
		}

		for (int argIndex = 0; argIndex < args.length; argIndex++)
		{
			FileInputStream	inFile;

			try {
				inFile = new FileInputStream(args[argIndex]);
			}
			catch(FileNotFoundException E)
			{	System.err.println("ERROR: unable to open \"" +
					args[argIndex] + "\" for reading");
				continue;
			}

			boolean	inword = false;		// are we in a word?
			int	lines = 0;		// number of lines
			int	words = 0;		// number of words
			int	chars = 0;		// number of characters

			for (int c = inFile.read(); c != -1; c = inFile.read())
			{
				chars++;

				switch(c)
				{	case '\n' :
						lines++;      // fall through
					case ' '  :
					case '\t' :
						inword = false;
						break;
					case '\r' :	      // for DOS/windows
						break;
					default   :
						if (!inword)   // start word
						{	inword = true;
							words++;
						}
						break;
				} // switch
			} // for

			inFile.close();

			System.out.println(rightJustify(lines+"", 8) +
				rightJustify(words+"", 8) +
				rightJustify(chars+"", 8));

			t_words += words;
			t_lines += lines;
			t_chars += chars;
		} // for each file name

		if (args.length > 1)
			System.out.println(rightJustify(t_lines+"", 8) +
				rightJustify(t_words+"", 8) +
				rightJustify(t_chars+"", 8) +
					" Total");
	} // main

} // class wc

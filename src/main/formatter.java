import java.io.*;
import java.nio.file.Paths;

class formatter
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        // PATH - USER INPUT
        File dir = new File(buf.readLine());
        
        File filelist[] = dir.listFiles();
        File f = null;
        String oldname = "", newname = "";
        int i, j;
        char ch;
        
        for(i = 0; i < filelist.length; i++)
        {
            newname = "";
            
            if(filelist[i].isFile())
            {
                f = new File(filelist[i].getName());
                oldname = f.toString();
                oldname = oldname.substring(oldname.lastIndexOf("-") + 2,oldname.length());
                
                for(j = 0; j < oldname.length() - 4; j++)
                {
                    ch = oldname.charAt(j);
                    
                    if(ch == '(')
                        break;
                    else
                        if(ch == ' ' || Character.isLetter(ch))
                            newname += ch;
                }
            }
            
            filelist[i].renameTo(new File(dir + "/" + newname.trim() + ".mp3"));
        }
    }
}

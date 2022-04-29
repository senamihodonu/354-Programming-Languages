BEGIN {
    print "<html>"
    print "  <table>"
}
{
    for (i=1; i<=NF; i++) {
        $i = toupper(substr($i,1,1)) tolower(substr($i,2))
    }
    if ( (NR%3) == 1 ) {
        if (NR>1) print "      </tr>"
        print "      <tr>"
    }
    printf "        <td>%s</td>\n", $0
}
END {
    for (i=NR+1; (i%3) != 1; i++) {
        printf "        <td>%s</td>\n", ""
    }
    print "      </tr>"

    print "  </table>"
    print "</html>"
}
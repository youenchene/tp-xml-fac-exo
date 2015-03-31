<?xml version="1.0"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.helloyou.fr" xmlns:date="http://exslt.org/dates-and-times" >

    <xsl:output method="html" indent="yes" />

    <xsl:template match="/resume">
        <html>
            <head>
                <title>Resume in HTML</title>
            </head>
            <body>
                <h1><xsl:value-of select="firstname"/> <xsl:value-of select="lastname"/></h1>
                <h2><xsl:value-of select="goal"/></h2>
                <h2>XP</h2>
                <ul>
                    <xsl:for-each select="xp">
                        <li><em><xsl:value-of select="date:format-date(startdate,'dd/MM/YYYY')"/></em> / <strong><xsl:value-of select="company"/></strong> -  <em><xsl:value-of select="position"/></em> : <xsl:value-of select="description"/></li>
                    </xsl:for-each>
                </ul>
            </body>
        </html>
    </xsl:template>



</xsl:stylesheet>
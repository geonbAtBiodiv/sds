/**************************************************************************
 *  Copyright (C) 2010 Atlas of Living Australia
 *  All Rights Reserved.
 * 
 *  The contents of this file are subject to the Mozilla Public
 *  License Version 1.1 (the "License"); you may not use this file
 *  except in compliance with the License. You may obtain a copy of
 *  the License at http://www.mozilla.org/MPL/
 * 
 *  Software distributed under the License is distributed on an "AS
 *  IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 *  implied. See the License for the specific language governing
 *  rights and limitations under the License.
 ***************************************************************************/
package org.ala.biocache.util;

/**
 * Object representing a legend item.
 * 
 * @author Adam
 */
public class LegendItem implements Comparable<LegendItem> {

    String name;
    long count;
    int colour;
    String fq;

    public LegendItem(String name, long count, String fq) {
        this.name = name;
        this.count = count;
        this.fq = fq;
    }

    public String getName() {
        return name;
    }

    public long getCount() {
        return count;
    }

    public String getFq() {
        return fq;
    }
    
    public void setColour(int colour) {
        this.colour = colour;
    }
    
    public int getColour() {
        return colour;
    }

    /**
     * Sort 'count', descending, then 'name' ascending.
     * @param o
     * @return
     */
    @Override
    public int compareTo(LegendItem o) {
        long c = count - o.count;
        if(c == 0) {
           if(name == null && o.name == null) {
                return 0;
            } else if(name == null) {
                return 1;
            } else if(o.name == null) {
                return -1;
            }
            return name.compareTo(o.name);
        } else {
            return (c>0)?-1:1;
        }
    }
}

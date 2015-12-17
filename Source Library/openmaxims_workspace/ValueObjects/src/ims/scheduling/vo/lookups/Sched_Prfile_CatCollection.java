//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.scheduling.vo.lookups;

import ims.framework.cn.data.TreeModel;
import ims.framework.cn.data.TreeNode;
import ims.vo.LookupInstanceCollection;
import ims.vo.LookupInstVo;

public class Sched_Prfile_CatCollection extends LookupInstanceCollection implements ims.vo.ImsCloneable, TreeModel
{
	private static final long serialVersionUID = 1L;
	public void add(Sched_Prfile_Cat value)
	{
		super.add(value);
	}
	public int indexOf(Sched_Prfile_Cat instance)
	{
		return super.indexOf(instance);
	}
	public boolean contains(Sched_Prfile_Cat instance)
	{
		return indexOf(instance) >= 0;
	}
	public Sched_Prfile_Cat get(int index)
	{
		return (Sched_Prfile_Cat)super.getIndex(index);
	}
	public void remove(Sched_Prfile_Cat instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public Object clone()
	{
		Sched_Prfile_CatCollection newCol = new Sched_Prfile_CatCollection();
		Sched_Prfile_Cat item;
		for (int i = 0; i < super.size(); i++)
		{
			item = this.get(i);
			newCol.add(new Sched_Prfile_Cat(item.getID(), item.getText(), item.isActive(), item.getParent(), item.getImage(), item.getColor(), item.getOrder()));
		}
		for (int i = 0; i < newCol.size(); i++)
		{
			item = newCol.get(i);
			if (item.getParent() != null)
			{
				int parentIndex = this.indexOf(item.getParent());
				if(parentIndex >= 0)
					item.setParent(newCol.get(parentIndex));
				else
					item.setParent((Sched_Prfile_Cat)item.getParent().clone());
			}
		}
		return newCol;
	}
	public Sched_Prfile_Cat getInstance(int instanceId)
	{
		return (Sched_Prfile_Cat)super.getInstanceById(instanceId);
	}
	public TreeNode[] getRootNodes()
	{
		LookupInstVo[] roots = super.getRoots();
		TreeNode[] nodes = new TreeNode[roots.length];
		System.arraycopy(roots, 0, nodes, 0, roots.length);
		return nodes;
	}
	public Sched_Prfile_Cat[] toArray()
	{
		Sched_Prfile_Cat[] arr = new Sched_Prfile_Cat[this.size()];
		super.toArray(arr);
		return arr;
	}
	public static Sched_Prfile_CatCollection buildFromBeanCollection(java.util.Collection beans)
	{
		Sched_Prfile_CatCollection coll = new Sched_Prfile_CatCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while(iter.hasNext())
		{
			coll.add(Sched_Prfile_Cat.buildLookup((ims.vo.LookupInstanceBean)iter.next()));
		}
		return coll;
	}
	public static Sched_Prfile_CatCollection buildFromBeanCollection(ims.vo.LookupInstanceBean[] beans)
	{
		Sched_Prfile_CatCollection coll = new Sched_Prfile_CatCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(Sched_Prfile_Cat.buildLookup(beans[x]));
		}
		return coll;
	}
}

package org.suw.learn.pattern.mdm;

import org.suw.learn.pattern.mdm.knowledgelevel.EntityType;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Entity<T extends EntityType> {
//	private Set<Association> parentAssociations = new HashSet<Association>();
//	private Set<Association> childAssociations = new HashSet<Association>();
	final private String name;
	
	final private T type;

//	public Entity(String name, T type) {
//		this.name = name;
//		this.type = type;
//	}

//	public Entity(String name) {
//		this.name = name;
//	}

	public T getType() {
		return type;
	}

//	void friendAddChildAssociation(Association arg) {
//		childAssociations.add(arg);
//	}
//
//	void friendAddParentAssociation(Association arg) {
//		parentAssociations.add(arg);
//	}

	public String getName() {
		return name;
	}

//	public Set<Entity> getParents() {
//		Set<Entity> result = new HashSet<Entity>();
//		for (Association association : parentAssociations) {
//			result.add(association.getParent());
//		}
//		return result;
//	}
//	
//	public Set<Entity> getParents(AssociationType associationType) {
//		Set<Entity> result = new HashSet<Entity>();
//		for (Association eachAssociation : parentAssociations) {
//			if (eachAssociation.getType().equals(associationType))
//				result.add(eachAssociation.getParent());
//		}
//		return result;
//	}
	
//	public Set<Entity> getChildren() {
//		Set<Entity> result = new HashSet<Entity>();
//		for (Association accountability : childAssociations) {
//			result.add(accountability.getChild());
//		}
//		return result;
//		
//	}
	
//	public boolean ancestorsInclude(Entity party, AssociationType type) {
//		Set<Entity> typedParentAccountabilities = getParents(type); 
//		for (Entity parent : typedParentAccountabilities) {
//			if (parent.equals(party)) 
//				return true;
//			if (parent.ancestorsInclude(party, type))
//				return true;
//		}
//		return false;
//	}

}

package cc.mallet.fst;

import java.io.Serializable;

import cc.mallet.types.Sequence;

public abstract class MaxLatticeFactory implements Serializable {
	private static final long serialVersionUID = -5307700628180959307L;

	public MaxLattice newMaxLattice (Transducer trans, Sequence inputSequence)
	{
		return newMaxLattice (trans, inputSequence, null);
	}
	
	// You may pass null for output
	public abstract MaxLattice newMaxLattice (Transducer trans, Sequence inputSequence, Sequence outputSequence);

}
